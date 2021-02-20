import React, { useEffect,useState } from 'react';
import cover2 from '../images/cover2.jpg';


function ListPlayedMatches() {

    return (        
            <div className="col text-center  bg-dark">
                <img style={{width:'100%',height:300}} src={cover2} alt="cover photo" />

                <br/>
                <button type="button" class="btn btn-light center" >Generate Match</button> 


                <h3 style={{color:'white'}}>All played matches</h3>

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


export default ListPlayedMatches;