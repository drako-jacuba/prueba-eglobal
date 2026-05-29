import { Link, Outlet } from "react-router-dom";

function Layout() {

    return (

        <div style={{
            display: "flex",
            minHeight: "100vh"
        }}>

            <aside style={{
                width: "250px",
                padding: "20px",
                borderRight: "1px solid gray"
            }}>

                <h2>Transaction System</h2>

                <hr />

                <p>
                    <Link to="/dashboard">
                        Dashboard
                    </Link>
                </p>

                <p>
                    <Link to="/transactions">
                        Transactions
                    </Link>
                </p>

                <p>
                    <Link to="/new-transaction">
                        New Transaction
                    </Link>
                </p>

                <p>
                    <Link to="/">
                        Logout
                    </Link>
                </p>

            </aside>

            <main style={{
                flex: 1,
                padding: "20px"
            }}>
                <Outlet />
            </main>

        </div>
    );
}

export default Layout;