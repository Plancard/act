import axios from "axios";

const BOARD_API_BASE_URL = "http://localhost:8080/board/"

class BoardService {
    getBoards(){
        return axios.get(BOARD_API_BASE_URL);
    }

    getBoard(no){
        return axios.get(BOARD_API_BASE_URL + no);
    }

    createBoard(board) {
        return axios.post(BOARD_API_BASE_URL, board);
    }

    updateBoard(no, board){
        return axios.put(BOARD_API_BASE_URL + no, board);
    }

    deleteBoard(no){
        return axios.delete(BOARD_API_BASE_URL + no);
    }

}

export default new BoardService();