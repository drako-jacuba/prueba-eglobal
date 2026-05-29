import axios from "axios";

const API_URL = "http://localhost:8001/api";

export const createTransaction = async (data) => {
  const response = await axios.post(`${API_URL}/transactions`, data);

  return response.data;
};

export const getTransactions = async (page = 0, size = 5) => {
  const response = await axios.get(
    `${API_URL}/transactions?page=${page}&size=${size}`,
  );

  return response.data;
};

export const getTransactionByReference = async (reference) => {

    const response =
        await axios.get(
            `${API_URL}/transactions/${reference}`
        );

    return response.data;
};

export const cancelTransaction = async (
    id,
    reference
) => {

    const response = await axios.patch(
        "http://localhost:8002/transactions/cancel",
        {
            id,
            reference,
            status: "cancel"
        }
    );

    return response.data;
};
