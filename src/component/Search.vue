<template>
    <div class="searchpage">
        <div class="searchpage-heading">Find your Station</div>
        <div class="searchpage-heading smaller">Search ID:</div>
        <input type="text" placeholder="Search for a Stop.." class="search" id="stop" @change="fetchSchedule()">

        <div class="schedule" id="schedule">
            <ul class="list-parent">
            </ul>
        </div>

        <footer>Powered by Netlify | 
            Github Link <a href="https://github.com/IvanZ505/HackRU">Here</a> | 
            Created For HackRU |
            Optimized for 16:9 / 19:10 Aspect Ratio
        </footer>
    </div>
</template>

<script>
    import { stop } from "vue"
import tripData from "../sample.json"

    export default {
        data() {
            return {
                successLocation: (position) => {
                    console.log(position)
                },
                error: (error) => {
                    console.log(error)
                },
                searchedTrip : 0

            }
        },
        methods: {
           fetchSchedule() {
                const stopHTML = document.getElementById('stop')
                const num = stopHTML.value
                const searchQuery = async function () {
                    try {
                        const response = tripData
                        //console.log(response)
                        //console.log(response.trip_id[num])
                        for(let i = 0; i< response.trip_id[num].length; i++) {
                            console.log(response.trip_id[num][i].stop_id)
                            const stop = response.trip_id[num][i].stop_id
                            const arrival_time = response.trip_id[num][i].arrival_time
                            const departure_time = response.trip_id[num][i].departure_time
                            const distance_traveled = response.trip_id[num][i].distance_traveled
                            var node = document.createElement('li');
                            document.getElementById('schedule').insertAdjacentHTML("beforeend", 
                            `<button class="schedule-btn">
                                Stop # ${stop}</button>
                                <div class="content">
                                <p>Arrival Time: ${arrival_time} Departure Time:  ${departure_time} Distance Traveled: ${distance_traveled}</p>
                            </div>`)
                            //newDiv.appendChild(document.createTextNode("Stop # " + stop + " Arrival Time: " + arrival_time + " Departure Time: " + departure_time))
                            //node.appendChild(newDiv)
                            //node.appendChild(document.createTextNode("Stop # " + stop));
 
                            //document.querySelector('ul').appendChild(node);
                        }
                        
                    } catch (e) {
                        console.log(e)
                    }
                }

                searchQuery()
           }
        }
    }
    
</script>