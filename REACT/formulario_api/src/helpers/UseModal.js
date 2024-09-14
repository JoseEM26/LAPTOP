import { useState } from "react";

export const UseModal = (inicial=false) => {
  const [open, setOpen] = useState(inicial)

  const openModal=()=>setOpen(true)
  const closeModal=()=>setOpen(false)

  return[open,openModal,closeModal];
};
