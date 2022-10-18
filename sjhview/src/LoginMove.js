import React from 'react';
import styled from 'styled-components';
import Counter from "./Counter";

const TodoTemplateBlock = styled.div`
  width: 768px;
  height: 768px;

  position: relative; /* 추후 박스 하단에 추가 버튼을 위치시키기 위한 설정 */
  background: white;
  border-radius: 16px;
  box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.04);

  margin: 0 auto; /* 페이지 중앙에 나타나도록 설정 */

  margin-top: 96px;
  margin-bottom: 32px;
  display: flex;
  flex-direction: column;
`;

// 폐기된 페이지
function LoginMove() {
    return <TodoTemplateBlock>
        <main>
            <div className="wrap login">
                <div className="info">
                    <h1><b>DEMANG</b></h1>
                </div>

                <form onSubmit={Counter}>

                        <div>
                            <div>
                                <h5><b>E-Mail</b></h5>
                                <input type="text" autoComplete="off" required></input>
                                <hr/>
                            </div>
                            <div>
                                <h5><b>PASSWORD</b></h5>
                                <input type="password" autoComplete="off" required/>
                                    <hr/>
                            </div>
                        </div>

                        <div>
                            <button type="submit" className="btn btn-primary">LOGIN</button>
                            {" "}
                            <button type="button" className="btn btn-primary" onClick="location.href='/signUp'">Sign Up
                            </button>
                        </div>
                </form>
            </div>
        </main>
    </TodoTemplateBlock>;
}

export default LoginMove;