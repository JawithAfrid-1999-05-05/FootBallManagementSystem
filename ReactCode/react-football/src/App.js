import './App.css';
import React from 'react';
import { BrowserRouter as Router , Route }  from "react-router-dom"; 

import NavBar from './components/NavBar.component';
import ListUniversityClubs from './components/ListUniversityClubs.component';
import ListSchoolClubs from './components/ListSchoolClubs.component';
import ListPlayedMatches from './components/ListPlayedMatches.component';
import ListPlayedMatchesByDate from './components/ListPlayedMatchesByDate';


function App(){

    return (
      <Router>
        <NavBar />
        <br/>

        <Route path="/" exact component={ListUniversityClubs} />    
        <Route path="/school" exact component={ListSchoolClubs} />                    
        <Route path="/playedmatches" component={ListPlayedMatches} />       
        <Route path="/findMatches" component={ListPlayedMatchesByDate} />      


      </Router>
      
    );
  
}
export default App;
