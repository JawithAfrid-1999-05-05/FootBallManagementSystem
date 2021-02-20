import React, { useEffect,useState } from 'react';

import cover3 from '../images/cover3.jpg';


function ListPlayedMatchesByDate() {

    
    return (
            <div className="col text-center  bg-dark">
             <img style={{width:'100%',height:'auto'}} src={cover3} alt="cover photo" />

                <br/>
            
            
            <br/>
                <h3 style={{color:'white'}}>Filter played matches by Date</h3>
                   
                <input style={{width:200, height:30}} type="text" placeholder="Enter date here" /> &nbsp;
                    <button type="button" class="btn btn-light center"  >View matches</button> 

                <div className="container">
                    <table className="table table-dark">
                        <thead>
                            <tr>
                                <th>Date</th>
                                <th>Team A</th>
                                <th>Score</th>
                                <th>Team B</th>
                                <th>Score</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            
                        </tbody>
                    </table>
                </div>
            </div>
        )
 }


export default ListPlayedMatchesByDate;