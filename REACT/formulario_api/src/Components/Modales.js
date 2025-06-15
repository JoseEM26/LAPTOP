import React from 'react'
import Modal from './Modal'
import {UseModal} from '../helpers/UseModal';

const Modales = () => {
    const [inicial1,openModal1,closeModal1]=UseModal(false);
    const [inicial2,openModal2,closeModal2]=UseModal(false);
    const [inicial3,openModal3,closeModal3]=UseModal(false);

  return (
    <>
    <h1>Modales</h1>
    <button onClick={openModal1}>Modal 1</button>
    <Modal inicio={inicial1}   closeModel={closeModal1}>
        <h2>Modal Numero 1</h2>
        <p>Objetos, Cosas de Viaje</p>
        <img src="https://picsum.photos/400/400" alt="Objetos"/>
    </Modal>

    <button onClick={openModal2}>Modal 2</button>
    <Modal inicio={inicial2}   closeModel={closeModal2}>
        <h2>Modal Numero 2</h2>
        <p>Objetos, Cosas de Viaje</p>
        <img src="https://picsum.photos/400/400" alt="Objetos"/>
    </Modal>

    <button onClick={openModal3}>Modal 3</button>
    <Modal inicio={inicial3}   closeModel={closeModal3}>
        <h2>Modal Numero 3</h2>
        <p>Objetos, Cosas de Viaje</p>
        <img src="https://picsum.photos/400/400" alt="Objetos"/>
    </Modal>
    </>
  )
}

export default Modales