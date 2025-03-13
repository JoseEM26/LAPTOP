import React, { useEffect, useState } from 'react'
import SongForm from './SongForm';
import SongDetails from './SongDetails';
import Loading from './Loading';
import helpHttps from '../helpers/helpHttps';


const SongSearch = () => {
  const [lyrics, setLyrics] = useState(null);
  const [bio, setBio] = useState(null);
  const [loading, setloading] = useState(false);
  const [search, setsearch] = useState(null);




  useEffect(() => {
    if (search === null) return;
    const fetchData =async () => {
      const { autor, musica } = search;

      const autorURL = `https://ws.audioscrobbler.com/2.0/?method=artist.search&artist=${autor}&api_key=YOUR_API_KEY&format=json`
      const musicaURL = `https://api.lyrics.ovh/v1/${autor}/${musica}`  

      setloading(true)

      const [autorRes,musicaRes]=await Promise.all([helpHttps().get(autorURL),helpHttps().get(musicaURL)]);
      setLyrics(musicaRes);
      setBio(autorRes);

      setloading(false )

    }

    fetchData();

  }, [search])


  const handleSearch = (data) => {
    setsearch(data)
    // console.log(data)
  }

  return (
    <>
      <h1>Buscador De Canciones:  </h1>
      {loading && <Loading />}
      <SongForm
        handleSearch={handleSearch}
      />

      {search&&<SongDetails
        bio={bio}
        lyrics={lyrics}
        search={search} />}
    </>
  )
}

export default SongSearch;
