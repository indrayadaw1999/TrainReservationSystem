document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('reservationForm');
    const responseMessage = document.getElementById('responseMessage');
    const seatsDisplay = document.getElementById('seatsDisplay');

    form.addEventListener('submit', async (e) => {
        e.preventDefault();

        const seats = document.getElementById('seats').value;

        try {
            const response = await fetch(`http://localhost:8080/api/reserve?seats=${seats}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                }
            });

            if (!response.ok) {
                throw new Error('Network response was not ok');
            }

            const data = await response.json();
            responseMessage.innerHTML = `Successfully reserved seats: ${data.map(seat => `Row ${seat.rowNumber}, Seat ${seat.seatNumber}`).join(', ')}`;
            
            // Display seats availability (optional)
            // Uncomment the following if you have an endpoint to get all seats
            /*
            const seatsResponse = await fetch('http://localhost:8080/api/seats');
            const seatsData = await seatsResponse.json();
            seatsDisplay.innerHTML = seatsData.map(seat => 
                `Row ${seat.rowNumber}, Seat ${seat.seatNumber}: ${seat.isReserved ? 'Reserved' : 'Available'}`
            ).join('<br/>');
            */
        } catch (error) {
            responseMessage.innerHTML = `Error: ${error.message}`;
        }
    });
});
