import React, {Component} from 'react';
import {Link} from "react-router-dom";

class Error extends Component {
    render() {
        return (
            <div>
                <p style={{marginTop:350}}/>
                이 곳은 에러 페이지 입니다
                <p/>

                <Link to={'/board'} className={'btn btn-primary'}>게시판으로 이동</Link>
            </div>
        );
    }
}

export default Error;