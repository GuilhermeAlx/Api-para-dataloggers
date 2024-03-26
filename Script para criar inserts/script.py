import random
import datetime
from datetime import timedelta


# Define a quantidade de números a gerar
num_inteiros = 10
num_dados=100

with open('data.sql', 'w') as f:
    for i in range(num_inteiros):
        
        f.write(f"INSERT INTO public.arduino(id_arduino, descricao, status) VALUES ('{i+1}', 'Arduino {i}', 'A');\r")


    start_date = datetime.date(2023, 10, 1)
    for i in range(num_dados):
            ID_ARDUINO = random.randint(1, (num_inteiros))
            FREQUENCIA = random.randint(1, 60)
            PRESAO = random.randint(1, 60)
            VAZAO = random.randint(1, 100)
            PRESSAOPROCESSADA = random.randint(1, 100)
            random_date = start_date + datetime.timedelta(days=random.randint(1, 100))
            random_hour=random.randint(0, 23)
            random_min=random.randint(0, 59)
            random_sec=random.randint(0, 59)

            f.write(f"INSERT INTO public.dado( id_dado, id_arduino,frequencia, pressao, pressao_processada, vazao, start_date_time) VALUES  ('{i+1}','{ID_ARDUINO}','{FREQUENCIA}','{PRESAO}','{VAZAO}','{PRESSAOPROCESSADA}','{random_date}T{random_hour}:{random_min}:{random_sec}');;\r")

