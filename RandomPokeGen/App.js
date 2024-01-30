
import './App.css';
import { useState, useEffect } from 'react';


  function getNewPokemonId(pokemon){
  pokemon =  Math.floor(Math.random() * 1011);
  console.log(pokemon)
  return pokemon;
}

function App() {
  const [pokemon , setNewPokemon] = useState(1);
  
  const fetchPokemon = async () => {
    const chosenPoke = getNewPokemonId()
    const response = await fetch(
      `https://pokeapi.co/api/v2/pokemon/${chosenPoke}`);
    const data = await response.json();
    setNewPokemon(data);
  };

  useEffect(() => {
    fetchPokemon();
  }, []);

  const handleOnClick = () => {
    fetchPokemon();
  }

  return (
    <main>
      <h1>
        Random Pokemon Generator
      </h1>
      <section>
        <button onClick={handleOnClick}>
          New Pokemon
        </button>
        <h3>{pokemon?.name}</h3>
      </section>

    </main>
  );
}

export default App;
