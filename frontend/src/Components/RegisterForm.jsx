import React, { useEffect, useState } from 'react';
import Axios from "axios";
import '../css/Login.css';

const RegisterForm = () => {
  const [inputEmail, setinputEmail] = useState('');
  const [inputUsername, setinputUsername] = useState('');
  const [inputPassword, setinputPassword] = useState('');

  const handleChange = (e) => {
    const { value, name } = e.target;
    if (name === 'email') setinputEmail(value);
    else if (name === 'username') setinputUsername(value);
    else if (name === 'password') setinputPassword(value);
  };

  const submitRegister = async (e) => {
    e.preventDefault(); 

    const requestForm = {
      email: inputEmail,
      username: inputUsername,
      password: inputPassword,
    };

    try {
      const res = await Axios.post('/users/register', requestForm);
      console.log('Register response:', res.data);
    } catch (error) {
      console.error('Register Error:', error.message);
    }
  };

  return (
    <div className='wrapper'>
      <form onSubmit={submitRegister}>
        <h1>Register</h1>
        <div className='input-box'>
          <input
            type='text'
            placeholder='email'
            name='email'
            value={inputEmail}
            onChange={handleChange}
            required
          />
        </div>
        <div className='input-box'>
          <input
            type='text'
            placeholder='username'
            name='username'
            value={inputUsername}
            onChange={handleChange}
            required
          />
        </div>
        <div className='input-box'>
          <input
            type='password'
            placeholder='password'
            name='password'
            value={inputPassword}
            onChange={handleChange}
            required
          />
        </div>
        <button type='submit'>Register</button>
      </form>
    </div>
  );
};

export default RegisterForm;
