import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import boardService from "../service/BoardService";

const BoardCreate = () => {

    const FormState = {
        p_title: "",
        p_content: "",
        p_nickname: ""
    };

    const [boards, setBoards] = useState({FormState});

    const {p_title, p_content, p_nickname} = boards;

    const onChange = (e) => {
        const { value, name } = e.target;
        setBoards({
            ...boards,
            [name]: value,
        });
    };

    const onSubmit = (e) => {
        e.preventDefault()
        if(!p_title){
            alert('제목을 작성해주세요');
            return;
        }else if (!p_content){
            alert('내용을 작성해주세요');
            return;
        }else if (!p_nickname){
            alert('작성자를 입력해주세요')
            return;
        }
        let variables = {
            p_title: p_title,
            p_content: p_content,
            p_nickname: p_nickname,
        };
        boardService.createBoard(variables).then(r => {
            if (r.status === 200){
                setBoards({
                    p_title:'',
                    p_content:'',
                    p_nickname:'',
                });
                navigate('/board')
            }else {
                alert('게시글 작성을 실패했습니다');
            }
        });
    }

    const navigate = useNavigate();

    // 뒤로가기
    const Cancel = () => {
        navigate('/board');
    }

    return(
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
                                        value={p_title}/>
                                    </div>
                                    <div className={"form-group"}>
                                        <label> Content </label>
                                        <textarea placeholder={"내용"} name={"p_content"} className={"form-control"} value={p_content} onChange={onChange}/>
                                    </div>
                                    <div className={"form-group"}>
                                        <label> Writer </label>
                                        <input type={"text"} placeholder={"작성자"} name={"p_nickname"} className={"form-control"} value={p_nickname} onChange={onChange}/>
                                    </div>
                                    <button className={"btn btn-success"} onSubmit={onSubmit}>Save</button>
                                    <button className={"btn btn-danger"} style={{marginLeft :"10px"}} onClick={Cancel}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
}

export default BoardCreate;