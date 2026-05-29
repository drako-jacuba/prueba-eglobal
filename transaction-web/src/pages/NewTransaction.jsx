import { useState } from "react";
import { createTransaction } from "../services/transactionService";

function NewTransaction() {

    const [operation, setOperation] = useState("");
    const [amount, setAmount] = useState("");
    const [client, setClient] = useState("");
    const [secret, setSecret] = useState("");

    const handleSubmit = async (e) => {

        e.preventDefault();

        try {

            const request = {
                operation,
                amount,
                client,
                secret
            };

            const response =
                await createTransaction(request);

            alert(
                "Transacción creada: " +
                response.reference
            );

            setOperation("");
            setAmount("");
            setClient("");
            setSecret("");

        } catch (error) {

            console.error(error);

            alert("Error creando transacción");
        }
    };

    return (

        <div>

            <h2>Nueva Transacción</h2>

            <form onSubmit={handleSubmit}>

                <input
                    placeholder="Operación"
                    value={operation}
                    onChange={(e) =>
                        setOperation(e.target.value)
                    }
                />

                <br />
                <br />

                <input
                    placeholder="Monto"
                    value={amount}
                    onChange={(e) =>
                        setAmount(e.target.value)
                    }
                />

                <br />
                <br />

                <input
                    placeholder="Cliente"
                    value={client}
                    onChange={(e) =>
                        setClient(e.target.value)
                    }
                />

                <br />
                <br />

                <input
                    placeholder="Secret"
                    value={secret}
                    onChange={(e) =>
                        setSecret(e.target.value)
                    }
                />

                <br />
                <br />

                <button type="submit">
                    Guardar
                </button>

            </form>

        </div>
    );
}

export default NewTransaction;