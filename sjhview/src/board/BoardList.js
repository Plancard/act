import React, {useEffect, useState} from 'react';
import boardService from "../service/BoardService";
import {useNavigate, Link} from "react-router-dom";

const BoardList = () => {

    // 조회 State는 Json 형태로 받아오기 때문에 내용이 빈 배열
    const [boards, setBoards] = useState([])
    const navigate = useNavigate()

    // boardService로 BackEnd와 통신하여 게시글 목록을 불러와 json 형태로 변환 및 호출
    useEffect(() => {
        boardService.getBoards()
            .then(response => setBoards(response.data))
            .catch(error => console.log(error))
    }, []);

    // 해당하는 게시물 번호로 이동하게 하는 function
    function readBoard(no) {
        navigate(`/board/${no}`);
    }

    return (
        <div>
            <h2 className={"text-center"}>Board List</h2>
            <div className={"row"}>
                <Link to={'/create-board'} className={"btn btn-primary"}>글 작성</Link>
            </div>
            <div className={"row"}>
                <table className={"table table-striped table-bordered"}>
                    <thead>
                    <tr>
                        <th>글번호</th>
                        <th>작성자</th>
                        <th>제목</th>
                        <th>내용</th>
                        <th>좋아요</th>
                        <th>조회수</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        boards.map(
                            board =>
                                <tr key={board.p_id}>
                                    <td> {board.p_id} </td>
                                    <td> {board.p_nickname} </td>
                                    <td onClick={() => readBoard(board.p_id)}> {board.p_title} </td>
                                    <td> {board.p_content} </td>
                                    <td> {board.likes} </td>
                                    <td> {board.counts} </td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default BoardList;