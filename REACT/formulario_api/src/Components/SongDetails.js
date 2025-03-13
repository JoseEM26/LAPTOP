import React from 'react'
import SongArtist from './SongArtist';
import SongLyrics from './SongLyrics';
import Mensaje from "./Mensaje"

 const SongDetails = ({bio,search,lyrics}) => {
  if(!lyrics,!bio)return null;


  return (
    <>
    {lyrics.error||lyrics.name==="AbortError"?<Mensaje/>:<SongArtist/>}
    <SongLyrics
    search={search}
    lyrics={lyrics}
    />
    </>
  )
}

export default SongDetails;
