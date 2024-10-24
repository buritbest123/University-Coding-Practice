import { useState } from "react"; // Importing in the React useState hook.
import "./App.css"; // Importing styles
import logo from "./images/movie-icon.png"; // Importing movie icon image
import TableDetail from "./Components/TableDetail"; // Importing TableDetail component
import axios from "axios"; // Importing axios for making API requests
import Box from '@mui/material/Box'; // Importing Box component from Material-UI
import Typography from '@mui/material/Typography'; // Importing Typography component from Material-UI
import Modal from '@mui/material/Modal'; // Importing Modal component from Material-UI

function App() {
  // State variables using useState hook
  const [name, setName] = useState("");
  const [id, setId] = useState("");
  const [year, setYear] = useState("");
  const [movies, setMovies] = useState([]);
  const [open, setOpen] = useState(false);
  const [clickID, setClickID] = useState(null);
  const [selectedMovie, setSelectedMovie] = useState({});

  // Event handler for opening modal
  const handleOpen = () => setOpen(true);

  // Event handler for closing modal
  const handleClose = () => setOpen(false);

  // Event handler for handling movie click
  const handleMovieClick = (item) => {
    setClickID(item.imdbID);
    handleOpen();
    searchAfterClick(item.imdbID);
  };

  // Style object for modal
  const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '2px solid #000',
    boxShadow: 24,
    p: 4,
  };

  // Function for searching movies based on input values
  const search = () => {
    let outstr = "";

    if (id) {
      outstr = `i=${id}&`;
    } else {
      if (name) {
        outstr += `s=${name}&`;
      }

      if (year) {
        outstr += `y=${year}&`;
      }
    }

    axios
      .get(`http://www.omdbapi.com/?${outstr}apikey=e061715`) // Making API request using axios
      .then((res) => {
        console.log(res.data);
        if (res.data.Response === "False" || !res.data) {
          console.log("Throw");
          throw new Error("False", 503);
        } else if (!res.data.Search) {
          setMovies([res.data]);
        } else {
          console.log(res.data.Search);
          console.log(name);
          setMovies(res.data.Search);
          console.log("Data replaced");
        }
      })
      .catch((err) => {
        console.log(err);
      });
  };

  // Function for searching movie details after movie click
  const searchAfterClick = async (imdbID) => {
    await axios
      .get(`http://www.omdbapi.com/?i=${imdbID}&apikey=e061715`) // Making API request using axios
      .then((res) => {
        console.log(res.data);
        setSelectedMovie(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <div className="movie-search">
      <header>
        <h1>MovieSearch</h1>
      </header>
      <img src={logo} height={200} width={200} alt="" /> <br />
      <input
        type="text"
        value={name}
        placeholder="Title..."
        onChange={(e) => {
          setName(e.target.value);
        }}
      />{" "}
      <input
        type="text"
        value={id}
        placeholder="IMDb ID..."
        onChange={(e) => {
          setId(e.target.value);
        }}
      />{" "}
      <input
        type="text"
        value={year}
        placeholder="Year..."
        onChange={(e) => {
          setYear(e.target.value);
        }}
      />{" "}
        <input 
        type="button" 
        onClick={() => search()} 
        value="Advance Search" />  
      <table>
        <thead>
          <tr>
            <th>Poster</th>
            <th>Title</th>
            <th>Year</th>
          </tr>
        </thead>
        <tbody>
          {/* Conditionally render table rows based on movies data */}
          {movies.length === 0 ? (
            <tr>
              <td colSpan={3}>No data to show</td>
            </tr>
          ) : (
            movies.map((item) => (
              // Render TableDetail component for each movie in movies array
              <TableDetail
                key={item.id}
                name={item.Title}
                id={item.imdbID}
                year={item.Year}
                image={item.Poster}
                onClick={() => handleMovieClick(item)} // pass click event handler
              />
            ))
          )}
        </tbody>
      </table>
      {/* Modal component to display movie details */}
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
        <Typography variant="h6" component="h2">
          {selectedMovie.Title}
        </Typography>
        <Typography sx={{ mt: 2 }}>
          Rate: {selectedMovie.Rated}
        </Typography>
        <Typography sx={{ mt: 2 }}>
          ID: {selectedMovie.imdbID}
        </Typography>
        <Typography sx={{ mt: 2 }}>
          Released: {selectedMovie.Released}
        </Typography>
        <Typography sx={{ mt: 2 }}>
          Runtime: {selectedMovie.Runtime}
        </Typography>
        <Typography sx={{ mt: 2 }}>
          Genre: {selectedMovie.Genre}
        </Typography>
        <Typography sx={{ mt: 2 }}>
          Director: {selectedMovie.Director}
        </Typography>
        <Typography sx={{ mt: 2 }}>
          Actors: {selectedMovie.Actors}
        </Typography>
        <Typography sx={{ mt: 2 }}>
          Plot: {selectedMovie.Plot}
        </Typography>
        </Box>
      </Modal>
    </div>
  );
}

export default App;