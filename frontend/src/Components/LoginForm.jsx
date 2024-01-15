import React, { useEffect, useState } from 'react';
import Axios from "axios";
import { FaUserAlt, FaLock } from "react-icons/fa";
import '../css/Login.css';

const LoginForm = () => {
    const [inputEmail, setInputEmail] = useState('');
    const [inputPassword, setInputPassword] = useState('');

    const submitLogin = async(e) => {
        const requestForm = {
            "email" : inputEmail,
            "password" : inputPassword
        }
        e.preventDefault();

        await Axios.post('/users/login', requestForm)
        .then((res) => {
            console.log("Login response : "+res);
        })
        .catch((error)=>{
            console.log("Login Error " + error);
        })
    }
  return (
    <div className='wrapper'>
        <form action=''>
            <h1>Login</h1>
            <div className='input-box'>
                <input type='text' placeholder='email' required/>
                <FaUserAlt className='login-icon'/>
            </div>
            <div className='input-box'>
                <input type='password' placeholder='password' required/>
                <FaLock className='login-icon'/>
            </div>

            <button type='submit' onClick={submitLogin}>Login</button>

            <div className='register'>
                <p>비밀번호를 잃어버렸습니까? <a href='#'>Register</a></p>
            </div>
        </form>
    
    </div>
  )
}

export default LoginForm;