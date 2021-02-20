import axios from 'axios'


const BASE_API_URL = 'http://localhost:8080/football'

class ClubsData {

    retrieveAllUniversityClubs(sortby) {
        return axios.get(`${BASE_API_URL}/university/${sortby}`);
    }

    retrieveAllSchoolClubs(sortby) {
        return axios.get(`${BASE_API_URL}/school/${sortby}`);
    }

}

export default new ClubsData()