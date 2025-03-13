import React from 'react'

 const SongLyrics = ({search,lyrics}) => {
  const {musica , autor}=search;
  return (
    <>
    <h2>{autor}//{musica}</h2>
    {/* <p>{lyrics}</p> */}
    </>
  )
}

export default SongLyrics;

