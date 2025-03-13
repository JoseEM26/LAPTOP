import React,{useRef} from "react";

export default function ReferenciasHUCKS() {
    
    const refMenuBtn = useRef();
    const refMenu = useRef();

    const handleToggleMenu=()=>{
        if(refMenuBtn.current.textContent==="Menu"){
            refMenu.current.style.display="block";
            refMenuBtn.current.textContent="Esconder";

        }else{
            refMenu.current.style.display="none";
            refMenuBtn.current.textContent="Menu";
        }

    }

    return(
        <>
        <h1>Referencias</h1>
        <button ref={refMenuBtn} onClick={handleToggleMenu}>Menu</button>
        <nav ref={refMenu} style={{display:"none"}} >
            <a href="/">enlace 1</a><br/>
            <a href="/">enlace 2</a><br/>
            <a href="/">enlace 3</a><br/>
            <a href="/">enlace 4</a><br/>
            <a href="/">enlace 5</a>

        </nav>
        </>
    )
}