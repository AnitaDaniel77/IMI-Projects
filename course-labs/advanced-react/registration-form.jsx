import "./App.css";
import { useState } from "react";
import { validateEmail } from "./utils";

const PasswordErrorMessage = () => {
  return (
    <p className="FieldError">Password should have at least 8 characters</p>
  );
};

function App() {
  const [firstName, setFirstName] = useState("")
  const [lastName, setLastName] = useState("")
  const [email, setEmail] = useState("")
  const [password, setPassword] = useState({
    value: "",
    isTouched: false,
  })
  const [role, setRole] = useState("role")

  // Step 4 — form is valid when all rules pass
  const getIsFormValid = () => {
    return (
      firstName !== "" &&
      validateEmail(email) &&
      password.value.length >= 8 &&
      (role === "individual" || role === "business")
    )
  }

  // Step 5 — reset all fields after submission
  const clearForm = () => {
    setFirstName("")
    setLastName("")
    setEmail("")
    setPassword({ value: "", isTouched: false })
    setRole("role")
  }

  // Step 3 — prevent default form behaviour
  const handleSubmit = (e) => {
    e.preventDefault()
    alert("Account created!")
    clearForm()
  }

  return (
    <div className="App">
      <form onSubmit={handleSubmit}>
        <fieldset>
          <h2>Sign Up</h2>

          {/* Step 1 — First name controlled input */}
          <div className="Field">
            <label>First name <sup>*</sup></label>
            <input
              placeholder="First name"
              value={firstName}
              onChange={e => setFirstName(e.target.value)}
            />
          </div>

          {/* Last name controlled input */}
          <div className="Field">
            <label>Last name</label>
            <input
              placeholder="Last name"
              value={lastName}
              onChange={e => setLastName(e.target.value)}
            />
          </div>

          {/* Email controlled input */}
          <div className="Field">
            <label>Email address <sup>*</sup></label>
            <input
              placeholder="Email address"
              value={email}
              onChange={e => setEmail(e.target.value)}
            />
          </div>

          {/* Password controlled input — obscured with type password */}
          <div className="Field">
            <label>Password <sup>*</sup></label>
            <input
              type="password"
              placeholder="Password"
              value={password.value}
              onChange={e => setPassword({ ...password, value: e.target.value })}
              // Step 2 — mark as touched when user leaves the field
              onBlur={() => setPassword({ ...password, isTouched: true })}
            />
            {/* Show error if touched and less than 8 characters */}
            {password.isTouched && password.value.length < 8 &&
              <PasswordErrorMessage />
            }
          </div>

          {/* Role controlled select */}
          <div className="Field">
            <label>Role <sup>*</sup></label>
            <select
              value={role}
              onChange={e => setRole(e.target.value)}
            >
              <option value="role">Role</option>
              <option value="individual">Individual</option>
              <option value="business">Business</option>
            </select>
          </div>

          <button type="submit" disabled={!getIsFormValid()}>
            Create account
          </button>
        </fieldset>
      </form>
    </div>
  )
}

export default App;