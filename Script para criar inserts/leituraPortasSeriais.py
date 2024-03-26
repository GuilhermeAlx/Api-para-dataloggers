import serial.tools.list_ports
ports = serial.tools.list_ports.comports()
import threading
import time


print("rodando")

def esperandoArduino():
    while (len( serial.tools.list_ports.comports()) == 0):
        time.sleep(0.01)

    ports = serial.tools.list_ports.comports()
    for port, desc, hwid in sorted(ports):
        print(port)

        if port.find("Arduino"):
            return (port)

porta=esperandoArduino()

class ReadLine:
    def __init__(self, s):
        self.buf = bytearray()
        self.s = s

    def readline(self):
        i = self.buf.find(b"\n")
        if i >= 0:
            r = self.buf[:i+1]
            self.buf = self.buf[i+1:]
            return r
        while True:
            i = max(1, min(2048, self.s.in_waiting))
            data = self.s.read(i)
            i = data.find(b"\n")
            if i >= 0:
                r = self.buf + data[:i+1]
                self.buf[0:] = data[i+1:]
                return r
            else:
                self.buf.extend(data)

ser = serial.Serial(porta, 115200)

rl = ReadLine(ser)
texto=''
with open('arduino.txt', 'w') as f:
    while not texto.find("finish"):
        texto=rl.readline().decode("utf-8")
        print(texto)
        if not (texto.find("finish")):   
            f.write(f'{texto}')
        else:
            break

    print("parou")


    







