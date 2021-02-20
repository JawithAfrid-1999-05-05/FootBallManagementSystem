import React, {Component} from "react";
import {Link} from "react-router-dom";

class NavBar extends Component {
    render() {
        return(
            <nav className="navbar navbar-dark bg-dark navbar-expand-lg">
                <Link to="/" className="navbar-brand">University Clubs</Link>
                <Link to="/school" className="navbar-brand">School Clubs</Link>

                <div className="collapse navbar-collapse">
                    <ul className="navbar-nav mr-auto">
                        <li className="navbar-item">
                            <Link to ="/playedmatches" className="nav-link">played matches</Link>
                        </li>
                        <li className="navbar-item">
                            <Link to ="/findmatches" className="nav-link">Find Match</Link>
                        </li>
                        
                    </ul>
                </div>

            </nav>
            
        )
    }
}

export default NavBar
