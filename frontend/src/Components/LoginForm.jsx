import React, { useEffect, useState } from 'react';
import Axios from "axios";
import { useNavigate } from "react-router-dom";
import { FaUserAlt, FaLock } from "react-icons/fa";
import '../css/Login.css';

const LoginForm = () => {
    const [inputEmail, setinputEmail] = useState('');
    const [inputPassword, setinputPassword] = useState('');
    const navigate = useNavigate();
  
    const submitLogin = async (e) => {
      e.preventDefault();

      const requestForm = {
        email: inputEmail,
        password: inputPassword,
      };
  
      try {
        const res = await Axios.post('/users/login', requestForm);
        console.log('Login response:', res);
        if (res.data.success) {
          navigate('/');
        } else {
          navigate('/fail');
        }
      } catch (error) {
        console.log('Login Error:', error);
        navigate('/fail');
      }
    };
  
    return (
      <div className='wrapper'>
        <form onSubmit={submitLogin}>
          <h1>Login</h1>
          <div className='input-box'>
            <FaUserAlt className='login-icon' />
            <input
              type='text'
              placeholder='email'
              value={inputEmail}
              onChange={(e) => setinputEmail(e.target.value)}
              required
            />
          </div>
          <div className='input-box'>
            <FaLock className='login-icon' />
            <input
              type='password'
              placeholder='password'
              value={inputPassword}
              onChange={(e) => setinputPassword(e.target.value)}
              required
            />
          </div>
  
          <button type='submit'>Login</button>
  
          <div className='register'>
            <p>
              비밀번호를 잃어버렸습니까? <a href='/register'>Register</a>
            </p>
          </div>
        </form>
      </div>
    );
  };
  
  export default LoginForm;