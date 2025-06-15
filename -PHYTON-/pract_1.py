numeros=[1,2,3,4,5,6,7,8]

numeros_par=filter(lambda numero:numero%2==0 , numeros)
print(list(numeros_par))
print(numeros_par)

personas=[("Jose",200) , ("Angel",44), ("Ariadna" ,100)]
print(personas)


print(personas.sort(key=lambda x:x[1]))