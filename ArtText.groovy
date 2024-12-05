import com.neuronrobotics.bowlerstudio.BowlerStudioController

import eu.mihosoft.vrl.v3d.*

def name
def print_fonts
if(args==null){
	//name = "mechEng"
	name = "boynton"
	println "No parameters found. Using name = "+name
	print_fonts = true
} else {
	name = args.get(0)
	println "Piece name sent to description text constructor: "+name
	print_fonts = false
}

def font = "FreeSerif Bold"
def size_pts = 8
def depth = 0.48

def spacing = 2

def size_in = size_pts / 72
def size_mm = size_in * 25.4
def spacing_mm = size_mm * 1.3 * 2.4

def mechEng_string = "Mechanical Engineers, workers of Worcester"
def boynton_string = "Boynton Hall and surroundings"
def WorcFreeInst_string = "Worcester Free Institute Buildings & Rooms, 1880"
def trotting_string = "Trotting cracks on the snow"
def CurrierIves_1853_string = "Currier & Ives, 1853"
def AAS_string = "Courtesy, American Antiquarian Society"

def firstLine_string
def secondLine_string
def thirdLine_string
switch (name) {
	case "mechEng":
		firstLine_string = mechEng_string
		secondLine_string = WorcFreeInst_string
		thirdLine_string = AAS_string
		break
	case "boynton":
		firstLine_string = boynton_string
		secondLine_string = WorcFreeInst_string
		thirdLine_string = AAS_string
		break
	case "trotting":
		firstLine_string = boynton_string
		secondLine_string = WorcFreeInst_string
		thirdLine_string = AAS_string
		break
	default:
		throw new Exception("Unknown option: $name")
		break
}

CSG firstLine = CSG.text(firstLine_string, depth, size_pts, font).movey(spacing_mm*2)
CSG secondLine = CSG.text(secondLine_string, depth, size_pts, font).movey(spacing_mm)
CSG thirdLine = CSG.text(thirdLine_string,depth, size_pts, font)

CSG ret = thirdLine.union(secondLine).union(firstLine)

ret = ret.movex(12).movey(15)
//ret = ret.mirrorx()

ret = ret.setColor(javafx.scene.paint.Color.PINK)
			.setName(name+"_desc_raw")
			.addAssemblyStep(0, new Transform())
			.setManufacturing({ toMfg ->
				return toMfg
						//.rotx(180)// fix the orientation
						//.toZMin()//move it down to the flat surface
			})

//if (print_fonts){
//	def fonts = javafx.scene.text.Font.getFontNames()
//	println fonts.size()
//}
			
if (print_fonts) {
	def fonts = javafx.scene.text.Font.getFontNames()
	def fontIndex = 0
	while (fontIndex < fonts.size()) {
	    def endFont = Math.min(fontIndex + 100, fonts.size())
	    def chunk = fonts.subList(fontIndex, endFont)
	    println "Fonts ${fontIndex+1} to $endFont:"
	    chunk.each { fontName -> println fontName }
	    Thread.sleep(100) // pause for 0.1 seconds
	    fontIndex += 100
	}
}

return ret