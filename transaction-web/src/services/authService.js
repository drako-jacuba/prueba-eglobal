import axios from "axios";

const API_URL = "http://localhost:8001";

export const login = async (credentials) => {
    const response = await axios.post(
        `${API_URL}/auth/login`,
        credentials
    );

    return response.data;
};