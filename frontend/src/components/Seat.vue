<template>
    <div class="container">
        <h1>座位更改系統</h1>
        <div class="select-area">
            <span>請選擇欲更改位置之員工：</span>
            <select v-model="selectedEmployee" @change="autoSelectFirstSeat" :disabled="employees.length === 0">
                <option v-for="employee in employees" :key="employee.empId" :value="employee">({{ employee.empId }}) {{ employee.name }}
                </option>
            </select>
        </div>
        <hr style="width: 75%;">
        <div class="seat-map">
            <button 
                v-for="seat in seatMap" 
                :key="seat.floor_seat_seq" 
                @click="selectSeat(seat)" 
                :class="{
                    'occupied': seat.empId, 
                    'selected': selectedSeat === seat.floorSeatSeq 
                }"
                :disabled="employees.length === 0 && !seat.empId">
                <span v-if="seat.empId">{{ seat.floorNo }}樓：座位{{ seat.seatNo }}
                    [員編：{{ seat.empId }}]</span>
                <span v-else>{{ seat.floorNo }}樓：座位{{ seat.seatNo }}</span>
            </button>
        </div>
        <input type="submit" value="送出" @click="assignSeat()" :disabled="employees.length === 0">
    </div>
</template>

<script>
import SeatService from '../services/SeatService'

export default {
    name: 'Seat',
    data() {
        return {
            employees: [],
            seatMap: [],
            selectedEmployee: null,
            selectedSeat: 0
        };
    },
    methods: {
        async getEmployees() {
            try {
                const response = await SeatService.getEmployees();
                this.employees = response.data;
            } catch (error) {
                console.error('Error fetching employees:', error);
            }
        },
        async getSeatingChart() {
            try {
                const response = await SeatService.getSeatingChart();
                this.seatMap = response.data;
            } catch (error) {
                console.error('Error fetching seating chart:', error);
            }
        },
        async deleteSeat(empId) {
            try {
                await SeatService.deleteSeat(empId);
                this.getSeatingChart();
            } catch (error) {
                console.error('Error deleting seat:', error);
            }
            
        },
        async selectSeat(seat) {
            if (seat.empId) {
                if (confirm('確定要清空座位嗎？')) {
                    await this.deleteSeat(seat.empId);
                    alert(`已清空 ${seat.floorNo}樓：座位${seat.seatNo} 的員工 ${seat.empId}`);
                    await this.getEmployees(); // 被清空位置的重新加回選單
                }
                return;
            }
            if (!this.selectedEmployee) {
                alert('請先選擇員工');
                return;
            }
            this.selectedSeat = seat.floorSeatSeq;
            console.log(this.selectedSeat);
        },
        async assignSeat() {
            if (!this.selectedEmployee) {
                alert('請先選擇員工');
                return;
            }
            try {
                const selectedSeat = this.seatMap.find(seat => seat.floorSeatSeq === this.selectedSeat);
                if(confirm(`確定要將員工 ${this.selectedEmployee.name} 安排到${selectedSeat.floorNo}樓：座位${selectedSeat.seatNo}嗎？`)) {
                    await SeatService.assignSeat(this.selectedEmployee.empId, this.selectedSeat);
                    alert(`已將員工 ${this.selectedEmployee.name} 安排到${selectedSeat.floorNo}樓：座位${selectedSeat.seatNo}`);
                    this.getSeatingChart();
                    this.getEmployees();
                    this.selectedEmployee = null;
                    this.selectedSeat = 0;
                }
            } catch (error) {
                console.error('Error changing seat:', error);
            }
        },
        autoSelectFirstSeat() {
            if (this.seatMap.length > 0) {
                const sorted = [...this.seatMap].filter(seat => !seat.empId).sort((a, b) => a.floor_seat_seq - b.floor_seat_seq);
                this.selectedSeat = sorted[0].floorSeatSeq;
            }
        }
    },
    async created() {
        await Promise.all([this.getEmployees(), this.getSeatingChart()])
    }
}

</script>

<style scoped>
.container {
    display: flex;
    flex-direction: column;
    align-items: center;
}

button.occupied {
    background-color: #f44336 !important;
    color: white;
}

button.selected {
    background-color: #68de84 !important;
    color: black;
}
.select-area {
    display: inline;
}
.seat-map {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    gap: 10px;
    width: 75%;
    margin-bottom: 10px;
}
.seat-map button {
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #f9f9f9;
    cursor: pointer;
}
</style>
