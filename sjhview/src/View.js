import React, {useEffect, useState} from 'react';
import axios from "axios";

// 테스트 페이지
function View(){
    const [all, setAll] = useState('')

    useEffect(() => {
        axios.get('/board/{num}')
            .then(response => setAll(response.data))
            .catch(error => console.log(error))
    }, []);

    return (
        <div>
            {all.content}
        </div>
    );
}

export default View;