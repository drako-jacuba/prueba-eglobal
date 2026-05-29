import { BrowserRouter, Routes, Route } from "react-router-dom";

import Login from "./pages/login";
import Transactions from "./pages/Transactions";
import NewTransaction from "./pages/NewTransaction";
import Dashboard from "./pages/Dashboard";
import Layout from "./components/Layout";
import TransactionDetail from "./pages/TransactionDetail";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />

        <Route element={<Layout />}>
          <Route path="/dashboard" element={<Dashboard />} />

          <Route path="/transactions" element={<Transactions />} />

          <Route path="/new-transaction" element={<NewTransaction />} />

          <Route path="/transactions/:reference" element={<TransactionDetail />}
/>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
