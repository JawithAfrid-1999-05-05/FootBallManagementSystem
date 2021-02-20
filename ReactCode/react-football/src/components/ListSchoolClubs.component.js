import React, { useEffect, useState } from 'react';

import cover from '../images/cover4.jpg';


function ListSchoolClubs() {
  
 
    return (
        <div class="col text-center  bg-dark">
    
            <img style={{width:'100%',height:400}} src={cover} alt="cover photo" />
            <br/>
            <h3 style={{color:'white'}}>All School football clubs</h3>
            <br/>

            <span style={{color:'white'}}>Sort by &nbsp;</span>
            <select >
                <option value="wins" >wins</option>
                <option value="goals" >goals</option>
            </select>
            <table className="table table-dark">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Location</th>
                        <th>Devision</th>
                        <th>points</th>
                        <th>wins</th>
                        <th>defeats</th>
                        <th>draws</th>
                        <th>goalsScored</th>
                        <th>goalsReceived</th>
                        <th>matchesPlayed</th>
                    </tr>
                </thead>
                <tbody>
                   
                </tbody>
            </table>
            </div>

        )
    
}

export default ListSchoolClubs