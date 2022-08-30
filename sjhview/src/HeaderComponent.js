import React, { Component } from 'react';
import {Link} from "react-router-dom";

class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }
    }
    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                        <div><a href="/" className="navbar-brand"> Spring Boot + React</a></div>
                        <Link to={'/board'} className={'navbar-brand'}>게시판</Link>
                        &nbsp;
                        <Link to={'/create-board'} className={'navbar-brand'}>글쓰기</Link>
                        &nbsp;
                        <Link to={'/chat'} className={'navbar-brand'}>채팅</Link>
                    </nav>
                </header>
            </div>
        );
    }
}

export default HeaderComponent;