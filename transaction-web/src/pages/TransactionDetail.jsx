import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

import { getTransactionByReference }
    from "../services/transactionService";

function TransactionDetail() {

    const { reference } = useParams();

    const [transaction, setTransaction] =
        useState(null);

    useEffect(() => {

        const fetchTransaction = async () => {

            try {

                const response =
                    await getTransactionByReference(
                        reference
                    );

                setTransaction(response);

            } catch (error) {

                console.error(error);

            }

        };

        fetchTransaction();

    }, [reference]);

    if (!transaction) {

        return <h2>Loading...</h2>;

    }

    return (

        <div>

            <h1>Transaction Detail</h1>

            <p>
                <strong>ID:</strong>
                {transaction.id}
            </p>

            <p>
                <strong>Reference:</strong>
                {transaction.reference}
            </p>

            <p>
                <strong>Client:</strong>
                {transaction.client}
            </p>

            <p>
                <strong>Operation:</strong>
                {transaction.operation}
            </p>

            <p>
                <strong>Status:</strong>
                {transaction.status}
            </p>

        </div>

    );
}

export default TransactionDetail;