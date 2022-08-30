import React, {useState} from "react";

const Counter = (props) => {

    const [number, setNumber] = useState(0);

    const onIncrease = () => {
        setNumber(number +1);
    }

    const onDecrease = () => {
        setNumber(number -1);
    }

    return(
        <div>
            <h1 style={{color : props.color}}>{number}</h1>
            <h2>{ props.name }</h2>
            <button onClick={onIncrease} type={"button"} className={"btn btn-primary"}>+1</button>
            <button onClick={onDecrease} type={"button"} className={"btn btn-primary"}>-1</button>
        </div>
    );
}

Counter.defaultProps = { name : '숫자 카운터', color : 'grey' }

export default Counter;