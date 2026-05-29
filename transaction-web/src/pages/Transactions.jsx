import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

import {
  getTransactions,
  cancelTransaction,
} from "../services/transactionService";

function Transactions() {
  const [transactions, setTransactions] = useState([]);

  const loadTransactions = async () => {
    try {
      const response = await getTransactions();

      setTransactions(response.content || []);
    } catch (error) {
      console.error(error);
    }
  };

  const handleCancel = async (id, reference) => {
    const confirmCancel = window.confirm(
      "¿Desea cancelar la transacción?"
    );

    if (!confirmCancel) {
      return;
    }

    try {
      await cancelTransaction(id, reference);

      alert("Transacción cancelada");

      await loadTransactions();
    } catch (error) {
      console.error(error);

      alert("Error cancelando transacción");
    }
  };

  useEffect(() => {
    const fetchData = async () => {
      await loadTransactions();
    };

    fetchData();
  }, []);

  return (
    <div>
      <h2>Transactions</h2>

      <table border="1" cellPadding="10" cellSpacing="0">
        <thead>
          <tr>
            <th>ID</th>
            <th>Reference</th>
            <th>Client</th>
            <th>Operation</th>
            <th>Status</th>
            <th>Detail</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          {transactions.map((item) => (
            <tr key={item.id}>
              <td>{item.id}</td>

              <td>{item.reference}</td>

              <td>{item.client}</td>

              <td>{item.operation}</td>

              <td
                style={{
                  color:
                    item.status === "Aprobada"
                      ? "limegreen"
                      : "red",
                  fontWeight: "bold",
                }}
              >
                {item.status}
              </td>

              <td>
                <Link
                  to={`/transactions/${item.reference}`}
                >
                  Ver
                </Link>
              </td>

              <td>
                {item.status === "Aprobada" ? (
                  <button
                    onClick={() =>
                      handleCancel(
                        item.id,
                        item.reference
                      )
                    }
                  >
                    Cancelar
                  </button>
                ) : (
                  "-"
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Transactions;