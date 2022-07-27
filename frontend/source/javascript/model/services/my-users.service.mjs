import { Config } from "../../config.mjs";
import { BoardModel } from "../board.model.mjs";
import { ColumnsForBoard } from "../columnsBoard.model.mjs";
import { UserModel } from "../user.model.mjs";

export class MyUsersService {

    constructor() { }

    async getUsers() {
        const data = await fetch(`${Config.BackendURL}/usuario/records`).then(response => response.json());
        const users = new Array();
        data.items.forEach(item => {
            const user = new UserModel(item);
            users.push(user);
        });
        return users;
    }

    async getBoard(){
        const result = await fetch(`${Config.BackendURL}/boards`).then(response => response.json());
        const board = new BoardModel(result.data);
        const columns = new Array();
        board.data.columnsForBoard.forEach(column => {
            columns.push(new ColumnsForBoard(column));
        });
        columns.ColumnsForBoard(columns);
        return board;
    }

    async getUserById(id) {
        const data = await fetch(`${Config.BackendURL}/usuario/records/${id}`).then(response => response.json());
        return new UserModel(data);
    }

    async update(id, data) {
        await fetch(
            `${Config.BackendURL}/usuario/records/${id}`,
            {
                method: 'PATCH',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data),
            }
        ).then(response => response.json());
    }

}