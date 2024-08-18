import React, { useReducer, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/login.css';
import { useDispatch } from 'react-redux';
import { login } from './slice';

function Login() {

const init = {
  username: '',
  password: ''
};


const reducer = (info, action) => {
  switch (action.type) {
    case 'update':
      return { ...info, [action.fld]: action.val };
    case 'reset':
      return init;
  }
};


  const [info, dispatch] = useReducer(reducer, init);
  const [msg, setMsg] = useState("");
  const navigate = useNavigate();
  const reduxAction = useDispatch();

  const sendData = (e) => {
    e.preventDefault();

    const reqOptions = {
      method: 'POST',
      headers: { 'content-type': 'application/json' },
      body: JSON.stringify(info),
    }

    fetch("https://localhost:7289/api/User/VerifyLogin", reqOptions)
    .then(resp => {if(resp.ok) 
                   {
                      console.log(resp.status);
                      return resp.text();
                   }
                   else 
                   {   
                      console.log(resp.status);
                      throw new Error('Server Error !!!')
                   }
    })
    .then(text => text.length ? JSON.parse(text) : {})
    .then(obj =>  {
                    if(Object.keys(obj).length === 0)
                        setMsg("Wrong UID/PWD !!!")
                    else
                    { 
                      console.log("in else");
                      reduxAction(login())
                       if(obj.status === false)
                       {
                          alert("Request has not been approved");
                          navigate("/");
                       }
                       else
                       {
                        sessionStorage.setItem('rid', obj.rid);
                        sessionStorage.setItem('userId', obj.userId);
                        console.log(sessionStorage.getItem('rid'));
                          if(obj.rid === 0)
                          {
                            console.log(obj.rid)
                            navigate("/admin")
                          }
                          else if(obj.rid === 1)
                          {
                            console.log(obj.rid)
                            navigate("/seller")
                          }
                          else if(obj.rid === 2)
                          {
                            console.log(obj.rid)
                            navigate("/buyer")
                          }
                          else alert("Wrong Username")
                       }
                    }
    })
    .catch((error) => { alert("Server error! Try after some time") });

  };
  return (
    <div>
      <div className="welcome-container">
        <h1 className="welcome-text">Welcome to VSEscrow</h1>
      </div>
      <div className="login-container">
        <form>
          <div className="mb-3">
            <input type="text" className="form-control" id="username" value={info.username} name='uid'
              onChange={(e) => {dispatch({ type: 'update', fld: 'username', val: e.target.value })}} placeholder="Enter Username" style={{ textAlign: 'center' }} required />
          </div>
          <div className="mb-3">
            <input type="password" className="form-control" id="password" value={info.password} name='pwd'
              onChange={(e) => {dispatch({ type: 'update', fld: 'password', val: e.target.value })}}placeholder="Enter password" style={{ textAlign: 'center' }} required />
          </div>
          <div className="button-group">
            <button type="submit" style={{ marginRight: '10px' }} className="btn btn-primary" onClick={(e) => {sendData(e)}}>Login</button>
            <button type="button" className="btn btn-secondary" onClick={() => { dispatch({type: 'reset'})} }>
              Reset
            </button>
          </div>
        </form>
        {/* <p> { JSON.stringify(info) } </p> */}
        <p>{msg}</p>
      </div>
    </div>
  );
}

export default Login;