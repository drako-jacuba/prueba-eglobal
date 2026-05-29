import { getTransactions } from "./transactionService";

export const loadDashboard = async () => {

    const response =
        await getTransactions(0, 100);

    return response.content;
};