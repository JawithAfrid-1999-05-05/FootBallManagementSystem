import axios from 'axios'

const TYPE = 'match'
const CLUB_API_URL = 'http://localhost:8080'
const BASE_API_URL = `${CLUB_API_URL}/${TYPE}`

class MatchData {

    retrieveAllMatches() {
        return axios.get(`${BASE_API_URL}/all`);
    }


    generateNewMatch() {
        return axios.get(`${BASE_API_URL}/random`);
    }

    retrieveMatchByDate(date) {
        return axios.get(`${BASE_API_URL}/${date}`);
    }
}

export default new MatchData()