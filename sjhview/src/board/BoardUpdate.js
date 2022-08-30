import React, {useEffect, useState} from 'react';
import boardService from "../service/BoardService";
import {useNavigate, useParams} from "react-router-dom";

const BoardUpdate = () => {

    const navigate = useNavigate();
    const { no } = useParams();
    const [boards, setBoards] = useState('')

    const onSubmit = (e) => {
        e.preventDefault()
        if(!boards.p_title){
            alert('제목을 작성해주세요');
            return;
        }else if (!boards.p_content){
            alert('내용을 작성해주세요');
            return;
        }else if (!boards.p_nickname){
            alert('작성자를 입력해주세요')
            return;
        }
        let variables = {
            p_title: boards.p_title,
            p_content: boards.p_content,
            p_nickname: boards.p_nickname,
        };
        boardService.updateBoard(no, variables).then(r => {
            if (r.status === 200){
                setBoards({
                    p_title:'',
                    p_content:'',
                    p_nickname:'',
                });
                navigate(`/board/${no}`)
            }else {
                alert('게시글 수정을 실패했습니다');
            }
        });
    }

    // 내용이 변화하면 기록
    const onChange = (e) => {
        const { value, name } = e.target;
        setBoards({
            ...boards,
            [name]: value,
        });
    };

    // 글 불러오기
    useEffect(() => {
        boardService.getBoard(no)
            .then(r => setBoards(r.data))
            .catch(error => console.log(error))
    }, []);

    // 뒤로가기
    const Cancel = () => {
        navigate(-1);
    }

    return (
        <div style={{marginTop:"200px"}}>
            <div className={"container"}>
                <div className={"row"}>
                    <div className={"card col-md-6 offset-md-3 offset-md-3"}>
                        <h3 className={"text-center"}>새 글을 작성해주세요</h3>
                        <div className={"card-body"}>
                            <form onSubmit={onSubmit}>
                                <div className={"form-group"}>
                                    <label> Title </label>
                                    <input type={"text"} placeholder={"제목"} name={"p_title"} className={"form-control"} onChange={onChange}
                                           value={boards.p_title}/>
                                </div>
                                <div className={"form-group"}>
                                    <label> Content </label>
                                    <textarea placeholder={"내용"} name={"p_content"} className={"form-control"} value={boards.p_content} onChange={onChange}/>
                                </div>
                                <div className={"form-group"}>
                                    <label> Writer </label>
                                    <input type={"text"} placeholder={"작성자"} name={"p_nickname"} className={"form-control"} onChange={onChange} value={boards.p_nickname} readOnly={boards.p_nickname}/>
                                </div>
                                <button className={"btn btn-success"} onSubmit={onSubmit}>Save</button>
                                <button className={"btn btn-danger"} style={{marginLeft :"10px"}} onClick={Cancel}>Cancel</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default BoardUpdate;