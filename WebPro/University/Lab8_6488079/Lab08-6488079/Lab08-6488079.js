// Import the necessary modules:
const http = require('http')
const fs = require('fs');
const path = require('path')

const server = http.createServer((req, res) => {
    // Server logic goes here
    if (req.url == '/') {
        // Handle root request
        console.log(`req: ${req.url}\nmet: ${req.method}`);

        // If the root route is requested, send a response containing the current time and date:
        res.statusCode = 200;
        const now = new Date();
        res.end(`
            <p>Hello from server</p>
            <p>Accessed: ${now.toString()}</p>
            <p>Timestamp: ${Date.now()}</p>
        `);
    }

   else if(req.url == '/search') {
        // Handle search request
        console.log(`req: ${req.url}\nmet: ${req.method}`);

        // If the /search route is requested, serve the contents of a file called search.html:
        fs.readFile("./search.html", function(err, data) {
            res.statusCode = 200;
            res.setHeader("Content-Type","text/html");
            res.write(data);
            res.end();
        });
    }
    else {
        // Handle all other requests
        console.log(`req: ${req.url}\nmet: ${req.method}`);

        // If any other route is requested, serve the contents of a file called error.html
        fs.readFile("./error.html", function(err, data) {            
            res.statusCode = 200;
            res.setHeader("Content-Type","text/html");
            res.write(data);
            res.end();
        });
    }
    
})

// Start the server and wait for incoming requests on port 8081:
server.listen(8081);
console.log('Server is listenin on port 8081');