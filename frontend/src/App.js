import {BrowserRouter, Routes, Route} from 'react-router-dom';
import  LoginForm  from './Components/LoginForm';
import RegisterForm from './Components/RegisterForm';
import Mainboard from './Components/Mainboard';
import Sucess from './Components/common/Sucess';
import Fail from './Components/common/Fail';
function App() {
  return (
    <div className="App">
    <BrowserRouter>
      
      <Routes>
        <Route path='/' element={<Mainboard/>}/>
         <Route path="/login" element={<LoginForm/>}/> 
         <Route path="/register" element={<RegisterForm/>}/>
         <Route path='/success' element={<Sucess/>}/>
         <Route path="/fail" element={<Fail/>}/>
      </Routes>
    </BrowserRouter>
    
  </div>
  );
}

export default App;
