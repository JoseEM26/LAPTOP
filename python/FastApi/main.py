from fastapi import FastAPI
from pydantic import BaseModel


app=FastAPI()

@app.get("/")
async def Rut():
    return "Hola Mundo"


class User(BaseModel):
    url : str
    age : int



