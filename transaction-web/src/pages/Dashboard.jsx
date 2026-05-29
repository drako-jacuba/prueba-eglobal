import { useEffect, useState } from "react";
import { loadDashboard } from "../services/dashboardService";

function Dashboard() {

    const [total, setTotal] = useState(0);
    const [approved, setApproved] = useState(0);
    const [cancelled, setCancelled] = useState(0);
    const [amount, setAmount] = useState(0);

    

    useEffect(() => {

    const fetchData = async () => {

        try {

            const transactions =
                await loadDashboard();

            setTotal(transactions.length);

            setApproved(
                transactions.filter(
                    t => t.status === "Aprobada"
                ).length
            );

            setCancelled(
                transactions.filter(
                    t => t.status === "Cancelada"
                ).length
            );

            const totalAmount =
                transactions.reduce(
                    (sum, t) =>
                        sum + (t.amount || 0),
                    0
                );

            setAmount(totalAmount);

        } catch (error) {

            console.error(error);

        }
    };

    fetchData();

}, []);

    return (
        <div>
            <h1>Dashboard</h1>
            <p>Total transactions: {total}</p>
            <p>Approved: {approved}</p>
            <p>Cancelled: {cancelled}</p>
            <p>Total amount: {amount}</p>

        </div>
    );
}

export default Dashboard;