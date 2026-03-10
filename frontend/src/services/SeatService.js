import axios from 'axios'

const API_URL = 'http://localhost:8080/api'

class SeatService {
    getSeatingChart() {
        return axios.get(`${API_URL}/seats`)
    }

    getEmployees() {
        return axios.get(`${API_URL}/unassigned-employees`)
    }

    deleteSeat(empId) {
        return axios.patch(`${API_URL}/employees/${empId}`)
    }

    assignSeat(empId, floorSeatSeq) {
        return axios.patch(`${API_URL}/employees/${empId}/assign-seat`, {
            floorSeatSeq: floorSeatSeq
        })
    }
}

export default new SeatService()
