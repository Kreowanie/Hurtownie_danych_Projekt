import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import "./App.css";

import Layout from "./components/Layout";
import CountryPage from "./pages/CountryPage";
import CustomerPage from "./pages/CustomerPage";
import DataQualityPage from "./pages/DataQualityPage";
import DatePage from "./pages/DatePage";
import ProductPage from "./pages/ProductPage";
import SourcePage from "./pages/SourcePage";
import TransactionTypePage from "./pages/TransactionTypePage";

function App() {
    return (
        <BrowserRouter>
            <Layout>
                <Routes>
                    <Route path="/" element={<Navigate to="/kraj" replace />} />
                    <Route path="/kraj" element={<CountryPage />} />
                    <Route path="/klient" element={<CustomerPage />} />
                    <Route path="/jakosc" element={<DataQualityPage />} />
                    <Route path="/data" element={<DatePage />} />
                    <Route path="/produkt" element={<ProductPage />} />
                    <Route path="/zrodlo" element={<SourcePage />} />
                    <Route path="/transakcje" element={<TransactionTypePage />} />
                </Routes>
            </Layout>
        </BrowserRouter>
    );
}

export default App;