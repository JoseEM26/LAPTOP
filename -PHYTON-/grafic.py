import pandas as pd
#visualizacion de datos
import matplotlib.pyplot as plt
#Graficos estadisticos
import seaborn as sns 

db=pd.read_csv("FastApi/aprende/pedos.csv")
print(db.sort_values(by="fecha"))

#ordenar de mayor a menor la fecha
data_orden=db.sort_values(by="fecha")


#mostrar y ajustar el grafico
# sns.lineplot(x="fecha",y="pedos",data=data_orden)
# sns.barplot(x="fecha",y="pedos",data=data_orden)
sns.scatterplot(x="fecha",y="pedos",data=data_orden)



#poner un punto en el mayor dia 
# plt.plot("01-12-24",85,"o")
plt.show()