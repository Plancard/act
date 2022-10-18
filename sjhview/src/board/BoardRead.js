import React, {useEffect, useState} from 'react';
import boardService from "../service/BoardService";
import {Link, useNavigate, useParams} from "react-router-dom";

const BoardRead = () => {

    const navigate = useNavigate();
    const { no } = useParams();
    const [boards, setBoards] = useState('')

    // 게시글 번호 확인
    console.log(no)

    // 게시글 하나 읽어오기
    useEffect(() => {
        boardService.getBoard(no)
            .then(r => setBoards(r.data))
            .catch(error => console.log(error))
    }, []);

    // 게시글 삭제버튼 활성화 시
    const deletePost = () => {
        if(window.confirm("글을 삭제하시겠습니까?")){
            boardService.deleteBoard(no)
                .then(r => console.log(JSON.stringify(r)));
            navigate('/board');
        }else {
            alert("글 삭제 취소/실패");
        }
    }

    // 수정 버튼
    const updatePost = () => {
        navigate(`/create-board/${no}`)
    }

    return (
        <div style={{marginTop:"200px"}}>
            <div className={"card col-md-6 offset-md-3"}>
                <h3 className={"text-center"}>글 상세보기</h3>
                <div className={"card-body"}>
                    <label className={"text-secondary"}> 제목 : </label> {boards.p_title}
                </div>

                <div className={"card-body"}>
                    <label className={"text-secondary"}> 내용 : </label> {boards.p_content}
                </div>

                <div className={"card-body"}>
                    <label className={"text-secondary"}> 작성자 : </label> {boards.p_nickname}
                </div>

                <Link to={"/board"} className={"btn btn-primary"}>돌아가기</Link>
                <button className={"btn btn-warning"} onClick={updatePost}>글 수정</button>
                <button className={"btn btn-danger"} onClick={deletePost}>글 삭제</button>

            </div>
        </div>
    );
}

export default BoardRead;