import {BrowserRouter, Routes, Route} from 'react-router-dom';
import  LoginForm  from './Components/LoginForm';

function App() {
  return (
    <div className="App">
    <BrowserRouter>
      
      <Routes>
        <Route path="/login" element={<LoginForm/>}/>
      </Routes>
    </BrowserRouter>
    
  </div>
  );
}

export default App;
